package speed_traffick_pack;


public class Place {
    Place north;
    Place south;
    Place east;
    Place west;
    boolean blocked;
    int grid_x, grid_y;

    public Place(boolean blocked, int grid_x, int grid_y) {
        this.blocked = blocked;
        this.grid_x = grid_x;
        this.grid_y = grid_y;
    }
    // Nuevo constructor para crear places sin grids mientras no los necesitemos
    public Place(boolean blocked) {
        this.blocked = blocked;
    }

    public Place getNorth() {
        return north;
    }

    public Place getSouth() {
        return south;
    }

    public Place getEast() {
        return east;
    }

    public Place getWest() {
        return west;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public int getGrid_x() {
        return grid_x;
    }

    public int getGrid_y() {
        return grid_y;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public void setGrid_x(int grid_x) {
        this.grid_x = grid_x;
    }

    public void setGrid_y(int grid_y) {
        this.grid_y = grid_y;
    }

    public void setNorth(Place north) {
        this.north = north;
    }

    public void setSouth(Place south) {
        this.south = south;
    }

    public void setEast(Place east) {
        this.east = east;
    }

    public void setWest(Place west) {
        this.west = west;
    }
    
    
	public boolean FreeToMove(int a) {
		boolean state_nextplace = false;
		if(a == 0) {
			state_nextplace = north.blocked;
		}
		if(a == 1) {
			state_nextplace = south.blocked;
		}
		if(a == 2) {
			state_nextplace = east.blocked;
		}
		if(a == 3) {
			state_nextplace = west.blocked;
		}
		return state_nextplace;
	}
    
}