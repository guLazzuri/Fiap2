import CrudDropdown from "./crud-dropdown";
import Icon from "./icon";

interface AssetsItemProps {
    assets: { icon: string; name: string; price: number; quantity: number }
}

export default function AssetsItem({ assets }: AssetsItemProps) {
    return (
        <div className="flex justify-between mt-2">
            <div className="flex gap-2">
                <Icon name={assets.icon} />
                <span>{assets.name}</span>
                <span>{assets.price}</span>
                <span>{assets.quantity}</span>
            </div>

            <div>
                <CrudDropdown />
            </div>
        </div>
    )
}