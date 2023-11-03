import { ActivityIndicator, FlatList, Text, View } from "react-native"
import { ApplicationStyles, Colors } from "../../theme"
import { AppCard, GeneralHeader } from "../../components"
import { Strings } from "../../constants"
import { useInstalledApps } from "../../hooks"
import styles from "./HomeScreenStyles"

export const HomeScreen = () => {

    const { apps } = useInstalledApps();

    return (
        <View style={ApplicationStyles.screenContainer}>
            <GeneralHeader
                title={Strings.installedApplications}
            />
            <FlatList
                data={apps}
                renderItem={({ item, index }) => {
                    return <AppCard appDetails={item} />
                }}
                ListHeaderComponent={() => {
                    if (apps?.length == 0) {
                        return (
                            <View style={{
                                justifyContent: "center",
                                alignItems: "center",
                                marginTop: 50,
                            }}>
                                <ActivityIndicator color={Colors.black} size={30} />
                            </View>
                        )
                    }
                    else {
                        return (
                            <Text style={styles.listTitleText}>
                                {apps.length} apps found.
                            </Text>
                        )
                    }
                }}
            />
        </View>
    )
}
