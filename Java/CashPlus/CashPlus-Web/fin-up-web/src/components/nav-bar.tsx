import Link from "next/link";

interface NavBarProps {
    active: "home" | "wallet" | "assets"
}

export default function NavBar(props: NavBarProps) {
    const { active } = props
    const activeClass = "border-b-4 border-primary pb-2"

    const links = [
        { text: "home", href: "/home" },
        { text: "wallet", href: "/wallet" },
        { text: "assets", href: "/assets" },
    ]

    return (
        <nav className="flex justify-between items-center bg-sidebar text-sidebar-foreground p-6">
            <h1 className="text-3xl font-bold">Cash+</h1>
            <ul className="flex gap-4">
                {links.map(link =>
                    <li key={link.text} className={active === link.text ? activeClass : ""}>
                        <Link href={link.href} className="hover:text-primary">
                            {link.text}
                        </Link>
                    </li>
                )}
            </ul>
            <img className="w-12 h-12 rounded-full border border-sidebar-border" src="http://github.com/gulazzuri.png" alt="" />
        </nav>
    )
}