package modele;



public class SiteApiculture {
 private int id;
 private double latitude;
 private double longitude;
 private double altitude;
 private String dateMiseEnService;
 private int idFerme;

 // Constructeur


 public SiteApiculture(int id, double latitude, double longitude, double altitude, String dateMiseEnService, int idFerme) {
     this.id = id;
     this.latitude = latitude;
     this.longitude = longitude;
     this.altitude = altitude;
     this.dateMiseEnService = dateMiseEnService;
     this.idFerme = idFerme;
 }

 // Getters
 public int getId() {
     return id;
 }

 public double getLatitude() {
     return latitude;
 }

 public double getLongitude() {
     return longitude;
 }

 public double getAltitude() {
     return altitude;
 }

 public String getDateMiseEnService() {
     return dateMiseEnService;
 }

 public int getIdFerme() {
     return idFerme;
 }

 // Setters
 public void setId(int id) {
     this.id = id;
 }

 public void setLatitude(double latitude) {
     this.latitude = latitude;
 }

 public void setLongitude(double longitude) {
     this.longitude = longitude;
 }

 public void setAltitude(double altitude) {
     this.altitude = altitude;
 }

 public void setDateMiseEnService(String dateMiseEnService) {
     this.dateMiseEnService = dateMiseEnService;
 }

 public void setIdFerme(int idFerme) {
     this.idFerme = idFerme;
 }

 // toString
 @Override
 public String toString() {
     return "SiteApiculture{" +
             "id=" + id +
             ", latitude=" + latitude +
             ", longitude=" + longitude +
             ", altitude=" + altitude +
             ", dateMiseEnService='" + dateMiseEnService + '\'' +
             ", idFerme=" + idFerme +
             '}';
 }
}

