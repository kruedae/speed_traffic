package speed_traffick_pack;


public class Road {
    private Place start;
    private Place end;
    private String direction;

    public Road(Place start, Place end, String direction) {
        this.start = start;
        this.end = end;
        this.direction = direction;
    }
    // Nuevo constructor para cuando recien se crea la clase. 
    // No pide el end ni el start sino que los inicializa 
    public Road(String direction) {
        this.start = new Place(false);
        this.end = this.start;
        this.direction = direction;
    }

    public Place getStart() {
        return start;
    }

    public Place getEnd() {
        return end;
    }

    public String getDirection() {
        return direction;
    }

    public void setStart(Place start) {
        this.start = start;
    }

    public void setEnd(Place end) {
        this.end = end;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
    
    // Cambie la funcion para que en lugar de recibir un place de entrada lo cree
    // Ademas lo puse como void porque no estaba retornando nada
    // Por ultimo hice que modificara la direccion
    public void addPlace(){
    	Place p = new Place(false);
        switch(this.direction){
            case "North":
                this.end.setNorth(p);
                this.end = p;
                break;
            case "South":
                this.end.setSouth(p);
                this.end = p;
                break;
            case "East":
                this.end.setEast(p);
                this.end = p;
                break;
            case "West":
                this.end.setWest(p);
                this.end = p;
                break;
        }
    }
    public void addPlace(Place p){
        switch(this.direction){
            case "North":
                this.end.setNorth(p);
                this.end = p;
                break;
            case "South":
                this.end.setSouth(p);
                this.end = p;
                break;
            case "East":
                this.end.setEast(p);
                this.end = p;
                break;
            case "West":
                this.end.setWest(p);
                this.end = p;
                break;
        }
    }

    public void removePlace(Place p){
        Place place =  this.start;
        while(place != p && place != null){
            switch(this.direction){
            case "North":
                place = place.getNorth();
                break;
            case "South":
                place = place.getSouth();
                break;
            case "East":
                place = place.getEast();
                break;
            case "West":
                place = place.getWest();
                break;
            }
        }
        
    }
}