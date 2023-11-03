import { StyleSheet } from "react-native"
import { Colors } from "../../theme";

const styles = StyleSheet.create({
    appCard: {
        padding: 15,
        flexDirection: "row",
    },
    appIcon: {
        width: 100,
        height: 100,
        objectFit: "cover",
    },
    appDetailsContainer: {
        marginLeft: 20,
        flex: 1,
        flexDirection: "column",
        justifyContent: 'space-around',
    },
    appName: {
        fontSize: 20,
        fontWeight: "500",
        color: Colors.black,
    },
    appPackageName: {
        fontSize: 15,
        color: Colors.grey,
    },
    appInstallDate: {
        flexDirection: "row",
        alignItems: "center",
    },
    appInstallDateText: {
        color: Colors.black,
        fontWeight: "500",
    }
})

export default styles;
