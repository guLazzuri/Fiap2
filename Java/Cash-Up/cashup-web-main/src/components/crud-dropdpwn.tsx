import {
    DropdownMenu,
    DropdownMenuContent,
    DropdownMenuItem,
    DropdownMenuLabel,
    DropdownMenuSeparator,
    DropdownMenuTrigger,
  } from "@/components/ui/dropdown-menu"
import { Ellipsis, Pencil, Trash2 } from "lucide-react"
  


export default function CrudDropdown(){

    return(
        <DropdownMenu>

            <DropdownMenuTrigger>
                <Ellipsis />
            </DropdownMenuTrigger>

            <DropdownMenuContent>
                <DropdownMenuLabel>My Account</DropdownMenuLabel>
                <DropdownMenuSeparator />
                <DropdownMenuItem><Pencil /> Editar</DropdownMenuItem>
                <DropdownMenuItem><Trash2 /> Delete</DropdownMenuItem>


        </DropdownMenuContent>
        </DropdownMenu>
    )
}


    
