import { redirect } from "next/navigation"

const API_URL = "http://localhost:8080/assets"

export async function getAssets() {
    const response = await fetch(API_URL)
    return await response.json()
}


export async function createAssets(initialState: any, formData: FormData){
    const data = {
        name: formData.get("name"),
        icon: formData.get("icon"),
        price: formData.get("price"),
        quantity: formData.get("quantity")
    }

    const options = {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    }

    const response = await fetch(API_URL, options)

    if(!response.ok){
        const errors = await response.json()

        return {
            values: {
                name: formData.get("name"),
                icon: formData.get("icon"),
                price: formData.get("price"),
                quantity: formData.get("quantity")
            },
            errors:{
                name: errors.find( (error: { field: string }) => error.field === "name")?.message,
                icon: errors.find( (error: { field: string }) => error.field === "icon")?.message,
                price: errors.find( (error: { field: string }) => error.field === "price")?.message,
                quantity: errors.find( (error: { field: string }) => error.field === "quantity")?.message
            }
        }
    }

    redirect("/assets")
}