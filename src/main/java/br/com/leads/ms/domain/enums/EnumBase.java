package br.com.leads.ms.domain.enums;

public interface EnumBase {

    Long getValue();

    static EnumBase fromById(Long id, Class<? extends EnumBase> clazz) {

        for (EnumBase enumBase : clazz.getEnumConstants()) {
            if (enumBase.getValue().equals(id)) {
                return enumBase;
            }
        }
        return null;
    }
}
