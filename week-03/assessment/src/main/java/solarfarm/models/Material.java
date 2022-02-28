package solarfarm.models;

public enum Material {
    MULTICRYSTALLINE_SILICON("Multicrystaline silicon"),
    MONOCRYSTALLINE_SILICON("Moncrystalline silicon"),
    AMORPHOUS_SILICON("Amorphous silicon"),
    CADMIUM_TELLURIDE("Cadmium telluride"),
    COPPER_INDIUM_GALLIUM_SELENIDE("Copper indium gallium selenide");

    private final String mat;
    Material(String mat) {
        this.mat = mat;
    }
    public String getMat(){return mat;}
}
