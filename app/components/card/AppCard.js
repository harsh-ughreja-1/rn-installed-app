import { Image, Pressable, Text, View } from "react-native";
import styles from "./AppCardStyles"

export const AppCard = ({
    appDetails
}) => {

    return (
        <Pressable style={styles.appCard}>
            <Image source={{ uri: `data:image/png;base64,${appDetails?.icon}` }} style={styles.appIcon} />
            <View style={styles.appDetailsContainer}>
                <Text style={styles.appName} numberOfLines={1}>{appDetails?.name}</Text>
                <Text style={styles.appPackageName} numberOfLines={1}>{appDetails?.packageName}</Text>
                <View style={styles.appInstallDate}>
                    <Text style={styles.appInstallDateText}>Date: {appDetails?.installDate}</Text>
                </View>
            </View>
        </Pressable>
    )
}
