import { Text, View } from "react-native"
import styles from "./HeaderStyles"

export const GeneralHeader = ({
    title
}) => {

    return (
        <View style={styles.headerContainer}>
            <Text style={styles.headerTitle}>
                {title}
            </Text>
        </View>
    )
}
