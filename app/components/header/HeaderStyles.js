import { StyleSheet } from "react-native"
import { Colors } from "../../theme";

const styles = StyleSheet.create({
    headerContainer: {
        paddingVertical: 15,
        paddingHorizontal: 20,
        flexDirection: "row",
        alignItems: "center",
        borderBottomWidth: 1,
        borderColor: Colors.lightgrey
    },
    headerTitle: {
        color: Colors.black,
        fontSize: 25,
        fontWeight: "600",
    }
})

export default styles;
