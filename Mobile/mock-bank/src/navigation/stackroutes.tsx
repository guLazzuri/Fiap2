import WelcomeScreen from '@/app/(auth)/Welcome';
import DashboardScreen from '@/app/(authenticated)/Dashboard';
import {createNativeStackNavigator} from '@react-navigation/native-stack'

const Stack = createNativeStackNavigator();

export function AuthRoutes(){
    return(
        <Stack.Navigator>
            <Stack.Screen name = "Welcome" component={WelcomeScreen}  />

        </Stack.Navigator>
    )
}

export function AuthenticateRoutes(){
    return(
        <Stack.Navigator>
            <Stack.Screen name = "DashboardScreen" component={DashboardScreen}  />

        </Stack.Navigator>
    )
}