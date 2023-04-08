package cscd212classes.lab2;

public class Television implements Comparable <Television> {
    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(final String make, final String model,
                      final boolean smart, final int screenSize, final int resolution) {

        if(make.isEmpty() ||model.isEmpty() || make == null || model == null ){
            throw new IllegalArgumentException();
        }
        if(screenSize < 32 || resolution < 720){
            throw new IllegalArgumentException();
        }

        this.make = make;
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;

        if(resolution == 2160){
            this.fourK = true;
        }
    }

    public Television(final String model, final boolean smart,
                      final int screenSize, final int resolution, final String make){
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.make = make;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public int getResolution() {
        return resolution;
    }

    @Override
    public String toString(){
        if(smart == true){
            return this.make + "-" + this.model + "," + this.screenSize +
                    " inch smart tv with " + this.resolution + " resolution.";
        }
        return this.make + "-" + this.model + "," + this.screenSize +
                " inch tv with " + this.resolution + " resolution.";

    }

    @Override
    public boolean equals(final Object o){

        if(o == this) return true;

        if(o == null) return false;

        if(!(o instanceof Television)) return false;

        return false;


    }

    @Override
    public int hashCode(){
        return this.make.hashCode() + this.model.hashCode() +
                resolution + Boolean.hashCode(this.smart) + Boolean.hashCode(this.fourK);

    }


    @Override
    public int compareTo(Television another) {
        if(another == null){
            throw new IllegalArgumentException("bad param");
        }
        if(this.make.compareTo(another.make)== 0){

            if (this.model.compareTo(another.model)== 0){

                return this.screenSize - another.screenSize;
            }
            return this.model.compareTo(another.model);
        }
        return this.make.compareTo(another.make);
    }



}
