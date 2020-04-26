package ir.ac.kntu.gamelogic;

public class SniperRifle extends Gun{

    private boolean zoom;

    public SniperRifle(Boolean zoom, int bullet) {
        super("SniperRifle", 20, 60 , bullet);
        setZoom(zoom);
        if(zoom){
            setAccuracy(getAccuracy() + RandomHelper.nextInt(16));
        }
        switch (bullet){
            case 0: // caliber 5
                setAccuracy(getAccuracy() + RandomHelper.nextInt(16));
                setBullet(5);
                break;
            case 1: // caliber 7
                setBullet(7);
                setAccuracy(getAccuracy() - 10);
                setDamage(getDamage() + 10);
                break;
            default:
                setAccuracy(getAccuracy() + RandomHelper.nextInt(16));
                setBullet(5);
                break;
        }
    }

    public boolean isZoom() {
        return zoom;
    }

    public void setZoom(boolean zoom) {
        this.zoom = zoom;
    }

}
