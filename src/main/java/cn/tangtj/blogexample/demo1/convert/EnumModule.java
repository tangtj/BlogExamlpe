package cn.tangtj.blogexample.demo1.convert;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class EnumModule extends Module {

    @Override
    public String getModuleName() {
        return "BaseEnumModule";
    }

    @Override
    public Version version() {
        return Version.unknownVersion();
    }

    @Override
    public void setupModule(SetupContext context) {
        context.addDeserializers(new BaseEnumDeserializers());
    }
}
