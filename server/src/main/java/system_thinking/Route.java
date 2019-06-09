package system_thinking;

public class Route {
    int id_route;
    String title;
    int placesnumber;
    String description;
    int time;
    Float rating;

    public int getId_route() {
        return id_route;
    }

    public void setId_route(int id_route) {
        this.id_route = id_route;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPlacesnumber() {
        return placesnumber;
    }

    public void setPlacesnumber(int placesnumber) {
        this.placesnumber = placesnumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Route(int id_route, String title, int placesnumber, String description, int time, Float rating) {
        this.id_route = id_route;
        this.title = title;
        this.placesnumber = placesnumber;
        this.description = description;
        this.time = time;
        this.rating = rating;
    }
}
