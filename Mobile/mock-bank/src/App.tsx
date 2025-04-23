import { View } from "@/components/Themed";
import { AuthenticateRoutes, AuthRoutes } from "./navigation/stackroutes";

export default function App(){
    const isAuthenticate = false;
    return(
        <View>  
            {isAuthenticate ? <AuthenticateRoutes/> : <AuthRoutes />}
        </View>
    )
}