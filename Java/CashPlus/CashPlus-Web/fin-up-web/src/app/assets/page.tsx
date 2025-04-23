import { getAssets } from "@/actions/assets-actions";
import AssetsItem from "@/components/assets-item";
import NavBar from "@/components/nav-bar";
import { Button } from "@/components/ui/button";
import { Plus } from "lucide-react";
import Link from "next/link";

export default async function Assets() {
    const data: Assets[] = await getAssets();

    return (
        <>
            <NavBar active="assets" />

            <main className="flex justify-center">
                <div className="border-2 border-green-600 min-w-2/3 m-6 p-6 rounded bg-white">
                    <div className="flex justify-between">
                        <h2 className="text-lg text-green-600 font-bold">Investimentos</h2>
                        <Button asChild>
                            <Link className="text-green-900" href="/assets/form">
                                <Plus />
                                novo investimento
                            </Link>
                        </Button>
                    </div>

                    {data.length == 0 ? (
                        <p className="text-green-900">Nenhum investimento cadastrado</p>
                    ) : (
                        data.map((assets) => <AssetsItem key={assets.id} assets={assets} />)
                    )}
                </div>
            </main>
        </>
    );
}
