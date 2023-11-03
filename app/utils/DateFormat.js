export const getInstallDate = (dateString) => {

    const [year, month, day] = dateString.split(' ')[0].split('-');

    return `${day.padStart(2, '0')}-${(month).toString().padStart(2, '0')}-${year.padStart(2, '0')}`
}
