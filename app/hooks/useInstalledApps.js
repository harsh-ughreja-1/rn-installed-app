import { useEffect, useState } from "react";
import { Alert, NativeModules } from 'react-native';
import { Strings } from "../constants";

export const useInstalledApps = () => {

    const [apps, setApps] = useState([]);

    const {InstalledAppsModule} = NativeModules;

    useEffect(() => {
        InstalledAppsModule.getInstalledApps().then((data) => {
            setApps(data);
        }).catch((error) => {
            Alert.alert('', Strings.somethingWentWrong);
        });
    }, []);

    return {
        apps
    }
}
