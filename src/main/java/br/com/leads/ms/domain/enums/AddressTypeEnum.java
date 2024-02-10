package br.com.leads.ms.domain.enums;

public enum AddressTypeEnum implements EnumBase {

    COMMERCIAL(1L),
    RESIDENTIAL(2L),
    BILLING(3L),
    OTHERS(4L);

    private final Long value;

    AddressTypeEnum(Long value) {
        this.value = value;
    }

    @Override
    public Long getValue() {
        return this.value;
    }

    public static AddressTypeEnum fromById(Long value) {
        return (AddressTypeEnum) EnumBase.fromById(value, AddressTypeEnum.class);
    }
}