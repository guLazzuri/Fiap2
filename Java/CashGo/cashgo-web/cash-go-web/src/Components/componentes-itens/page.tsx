import { BadgeDollarSign, Bitcoin, DollarSign, Search } from "lucide-react";

export default function CategoryItem() {
    return (
        <div className="  flex flex-col mt-2 gap-2  border border-green-500 p-4 rounded-lg">
            {/* Filtro e busca */}
            <div className="flex justify-between items-center mb-2">
                <input type="text" placeholder="Filtrar..." className="border border-green rounded px-2 py-1" />
                <div className="flex items-center border border-green rounded px-2 py-1">
                    <Search className="w-4 h-4 mr-1" />
                    <input type="text" placeholder="Buscar..." className="outline-none" />
                </div>
            </div>
            
            {/* Lista de moedas */}
            <div className="flex items-center gap-2">
                <DollarSign />
                <span>Dólar</span>
                <span className="ml-auto">$1.00 ...</span>
            </div>
            <div className="flex items-center gap-2">
                <DollarSign />
                <span>Euro</span>
                <span className="ml-auto">$1.10 ...</span>
            </div>
            <div className="flex items-center gap-2">
                <Bitcoin />
                <span>BitCoin</span>
                <span className="ml-auto">$45,000.00 ...</span>
            </div>
            <div className="flex items-center gap-2">
                <BadgeDollarSign />
                <span>Ethereum</span>
                <span className="ml-auto">$3,200.00 ...</span>
            </div>
            <div className="flex items-center gap-2">
                <BadgeDollarSign />
                <span>Petrobras</span>
                <span className="ml-auto">$14.50 ...</span>
            </div>
            
            {/* Caixa para adicionar novas moedas */}
            <div className="mt-4 border border-green rounded px-4 py-2 text-center text-white cursor-pointer">
                + Nova Moeda
            </div>
            
            {/* Total */}
            <div className="flex justify-between mt-4 font-bold">
                <span>Total</span>
                <span>$48,216.60</span>
            </div>
        </div>
    );
}