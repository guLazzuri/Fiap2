import CategoryItem from "@/Components/componentes-itens/page";
import NavBar from "@/Components/header/page";

export default function Wallet(){
    return (
        <>
           <NavBar active="wallet" />

            <main className="bg-black flex flex-1">
                <div className=" min-w-2/3 m-6 p-6 rounded">
                    <h2 className="text-lg font-bold">Wallet</h2>

                    <CategoryItem />


                </div>
            </main>
        </>
    )
}