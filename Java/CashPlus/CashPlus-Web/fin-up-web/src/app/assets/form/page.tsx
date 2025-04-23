"use client";

import { createAssets } from "@/actions/assets-actions";
import NavBar from "@/components/nav-bar";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { ArrowLeft, Check } from "lucide-react";
import Link from "next/link";
import { useActionState } from "react";

const initialState = {
    values: {
        name: "",
        icon: "",
        price: null as FormDataEntryValue | null,
        quantity: null as FormDataEntryValue | null
    },
    errors: {
        name: "",
        icon: "",
        price: "",
        quantity: ""
    }
};

export default function AssetsFormPage() {
    const [state, formAction, pending] = useActionState(createAssets, initialState);

    return (
        <>
            <NavBar active="assets" />

            <main className="flex justify-center">
                <div className="border-2 border-primary min-w-2/3 m-6 p-6 rounded bg-card text-card-foreground">
                    <h2 className="text-lg font-bold text-primary">Cadastrar Ativo</h2>

                    <form action={formAction} className="space-y-4 mt-4">
                        <div>
                            <Input
                                name="name"
                                placeholder="nome do ativo"
                                aria-invalid={!!state?.errors.name}
                                defaultValue={typeof state?.values.name === "string" ? state.values.name : ""}
                                className="bg-input text-foreground"
                            />
                            <span className="text-sm text-destructive">{state?.errors.name}</span>
                        </div>

                        <div>
                            <Input
                                name="icon"
                                placeholder="ícone do ativo"
                                aria-invalid={!!state?.errors.icon}
                                defaultValue={typeof state?.values.icon === "string" ? state.values.icon : ""}
                                className="bg-input text-foreground"
                            />
                            <span className="text-sm text-destructive">{state?.errors.icon}</span>
                        </div>

                        <div>
                            <Input
                                name="price"
                                placeholder="preço do ativo"
                                type="number"
                                aria-invalid={!!state?.errors.price}
                                defaultValue={typeof state?.values.price === "number" ? state.values.price : ""}
                                className="bg-input text-foreground"
                            />
                            <span className="text-sm text-destructive">{state?.errors.price}</span>
                        </div>

                        <div>
                            <Input
                                name="quantity"
                                placeholder="quantidade do ativo"
                                type="number"
                                aria-invalid={!!state?.errors.quantity}
                                defaultValue={typeof state?.values.quantity === "string" ? state.values.quantity : ""}
                                className="bg-input text-foreground"
                            />
                            <span className="text-sm text-destructive">{state?.errors.quantity}</span>
                        </div>

                        <div className="flex justify-between">
                            <Button className="bg-secondary text-secondary-foreground" asChild variant={"outline"}>
                                <Link href="/assets">
                                    <ArrowLeft />
                                    Cancelar
                                </Link>
                            </Button>

                            <Button type="submit" className="bg-primary text-primary-foreground">
                                <Check />
                                Salvar
                            </Button>
                        </div>
                    </form>
                </div>
            </main>
        </>
    );
}