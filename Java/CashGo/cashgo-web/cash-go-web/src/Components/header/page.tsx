import { CircleDollarSign, House, WalletCards } from "lucide-react";
import Link from "next/link";

interface NavBarProps {
    active: "home" | "wallet" | "investment"
}

export default function Header(props: NavBarProps) {
    const { active } = props
    const activeClass = "border-b-4 border-white pb-2"

    const links = [
        { text: "home", href: "/Home", icon: <House />  },
        { text: "wallet", href: "/Wallet", icon: <WalletCards /> },
        { text: "investment", href: "/Investment", icon: <CircleDollarSign /> },
    ]

    return (
        <nav className="flex flex-col h-full max-w-[350px] w-full bg-green-800 p-4 gap-5">
            <h1 className="text-3xl font-bold gap-8">CashUp</h1>

            <ul className="flex flex-col gap-4 flex-1 ">
                {links.map(link =>
                    <li className={`flex flex-row items-center  gap-3 ${active === link.text && activeClass}` }>
                        {link.icon}
                        <Link href={link.href}>{link.text}</Link>
                    </li>
                )}

            </ul>
            <img className="size-12 rounded-full" src="http://github.com/guLazzuri.png" alt="" />
        </nav>
    )
}