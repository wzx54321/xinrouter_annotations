package com.xin.router.annotations;

public class RouterUtils {

    static final String PACKAGE_NAME = "com.xin.router.host";

    public static String getBridgeClassAllName(String host) {

        return PACKAGE_NAME + "." + getBridgeClassName(host);
    }

    public static String getBridgeClassName(String host) {
        String BRIDGE = "Bridge_";
        return BRIDGE + host.replace(".", "_").replace("/", "_");
    }


    public static String getPagkageName() {

        return PACKAGE_NAME;
    }

    public static boolean isEmpty(String name) {

        return name == null || name.length() == 0;
    }

    public static String getParameterKey(String path) {

        return path + "parameter_keys";
    }


    public static String getFullTypesString(String agrsTypes) {
        if (agrsTypes.contains(",")) {
            String[] arr = agrsTypes.split(",");
            StringBuilder builder = new StringBuilder();
            boolean mapAppear = false;
            for (String s : arr) {
                if (mapAppear) {
                    mapAppear = false;
                    continue;
                }
                if (s.contains("Map"))
                    mapAppear = true;
                builder.append(removeGeneric(s)).append(".class,");

            }
            String result = builder.toString();
            return result.substring(0, result.length() - 1);
        } else {
            return removeGeneric(agrsTypes) + ".class";
        }
    }

    // "List<String>" => "List"
    private static String removeGeneric(String argType) {
        int index = argType.indexOf("<");
        if (index != -1) {
            argType = argType.substring(0, index);
        }
        return argType;
    }
}
