package system_thinking;

public class Location {
    int id_place;
    String title;
    Float coords;
    Float coordd;
    String description;
    String imgurl;
    Float rating;
    int route;
    Float money;

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public int getRoute() {
        return route;
    }

    public void setRoute(int route) {
        this.route = route;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public int getId_place() {
        return id_place;
    }

    public void setGeo_id(Integer id_place) {
        this.id_place = id_place;
    }

    public String getGeoname() {
        return title;
    }

    public void setGeoname(String geoname) {
        this.title = title;
    }

    public Float getLon() {
        return coords;
    }

    public void setLon(Float lon) {
        this.coords = coords;
    }

    public Float getLat() {
        return coordd;
    }

    public void setLat(Float lat) {
        this.coordd = coordd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return imgurl;
    }

    public void setImg(String img) {
        this.imgurl = img;
    }

    public Location(int geo_id, String geoname, Float lon, Float lat, String description, String img, Float rating, int route, Float money) {
        this.id_place = geo_id;
        this.title = geoname;
        this.coords = lon;
        this.coordd = lat;
        this.description = description;
        this.imgurl = img;
        this.rating = rating;
        this.route = route;
        this.money = money;
    }
}
