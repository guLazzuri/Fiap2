import NavBar from "@/components/nav-bar";

export default function DashboardPage(){
    return (
        <>
           <NavBar active="home" />

            <main className="flex justify-center">
                <div className="border-2 border-primary min-w-2/3 m-6 p-6 rounded">
                    <h2 className="text-lg font-bold text-primary">Home</h2>
                </div>
            </main>
        </>
    )
}