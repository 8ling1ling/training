let SystemConfig = System.getTinyConfig();
let SystemInfo = System.info();
// let BaseUrl = "http://192.168.1.104:8088/";
let BaseUrl = "http://10.25.1.226:8088/";
const config = {
    debug: true,
    system: {
        // tinyBuilder.json
        config: SystemConfig,
        info: SystemInfo,
        countdown: 30,
        gesturePasswordLength: 5,
    },
    const: {
        popupDisplayTime: 2000
    },
    net: {
        timeout: 30
    }
}