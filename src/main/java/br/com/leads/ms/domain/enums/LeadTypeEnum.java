package br.com.leads.ms.domain.enums;

public enum LeadTypeEnum implements EnumBase {

    CLIENT(1L),
    PROSPECT(2L),
    PARTNER(3L),
    SUPPLIER(4L),
    OTHERS(5L);

    private final Long value;

    LeadTypeEnum(Long value) {
        this.value = value;
    }

    @Override
    public Long getValue() {
        return this.value;
    }

    public static LeadTypeEnum fromById(Long value) {
        return (LeadTypeEnum) EnumBase.fromById(value, LeadTypeEnum.class);
    }
}
