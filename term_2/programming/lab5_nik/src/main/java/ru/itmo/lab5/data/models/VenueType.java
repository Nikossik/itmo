package ru.itmo.lab5.data.models;

public enum VenueType {
    LOFT,
    OPEN_AREA,
    THEATRE,
    STADIUM;

    /**
     * Возвращает строку, содержащую все значения перечисления, разделенные запятыми.
     *
     * @return Строка со всеми типами мест проведения.
     */
    public static String names() {
        StringBuilder nameList = new StringBuilder();
        for (var venueType : values()) {
            nameList.append(venueType.name()).append(", ");
        }
        return nameList.substring(0, nameList.length() - 2);
    }
}
