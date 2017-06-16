package nightplex.model.skills.barkeeping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * Store all your raw materials here..
 * 
 * NightPlex--
 * 
 * */

@Entity
public class BarStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    // Materials - self explanatory . Products :

    private int apples, barley, blackCurrants, blueAgave, camomileLeaves, caramel, cherries, cocaLeaves, coffeeBeans,
            corn, cowBerries, cranBerries, darkGrapes, gooseBerries, grapeFruits, honey, jupiterBerries, lemons,
            lightGrapes, nettleLeaves, oranges, pears, pepper, plums, rasperries, rawMilk, redCurrants, rye,
            strawberries, sugar, teaTreeBlossum, teaTreeLeaves, vanilla, water, wheat, yeast;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getApples() {
        return apples;
    }

    public void setApples(int apples) {
        this.apples = apples;
    }

    public int getBarley() {
        return barley;
    }

    public void setBarley(int barley) {
        this.barley = barley;
    }

    public int getBlackCurrants() {
        return blackCurrants;
    }

    public void setBlackCurrants(int blackCurrants) {
        this.blackCurrants = blackCurrants;
    }

    public int getBlueAgave() {
        return blueAgave;
    }

    public void setBlueAgave(int blueAgave) {
        this.blueAgave = blueAgave;
    }

    public int getCamomileLeaves() {
        return camomileLeaves;
    }

    public void setCamomileLeaves(int camomileLeaves) {
        this.camomileLeaves = camomileLeaves;
    }

    public int getCaramel() {
        return caramel;
    }

    public void setCaramel(int caramel) {
        this.caramel = caramel;
    }

    public int getCherries() {
        return cherries;
    }

    public void setCherries(int cherries) {
        this.cherries = cherries;
    }

    public int getCocaLeaves() {
        return cocaLeaves;
    }

    public void setCocaLeaves(int cocaLeaves) {
        this.cocaLeaves = cocaLeaves;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    public int getCorn() {
        return corn;
    }

    public void setCorn(int corn) {
        this.corn = corn;
    }

    public int getCowBerries() {
        return cowBerries;
    }

    public void setCowBerries(int cowBerries) {
        this.cowBerries = cowBerries;
    }

    public int getCranBerries() {
        return cranBerries;
    }

    public void setCranBerries(int cranBerries) {
        this.cranBerries = cranBerries;
    }

    public int getDarkGrapes() {
        return darkGrapes;
    }

    public void setDarkGrapes(int darkGrapes) {
        this.darkGrapes = darkGrapes;
    }

    public int getGooseBerries() {
        return gooseBerries;
    }

    public void setGooseBerries(int gooseBerries) {
        this.gooseBerries = gooseBerries;
    }

    public int getGrapeFruits() {
        return grapeFruits;
    }

    public void setGrapeFruits(int grapeFruits) {
        this.grapeFruits = grapeFruits;
    }

    public int getHoney() {
        return honey;
    }

    public void setHoney(int honey) {
        this.honey = honey;
    }

    public int getJupiterBerries() {
        return jupiterBerries;
    }

    public void setJupiterBerries(int jupiterBerries) {
        this.jupiterBerries = jupiterBerries;
    }

    public int getLemons() {
        return lemons;
    }

    public void setLemons(int lemons) {
        this.lemons = lemons;
    }

    public int getLightGrapes() {
        return lightGrapes;
    }

    public void setLightGrapes(int lightGrapes) {
        this.lightGrapes = lightGrapes;
    }

    public int getNettleLeaves() {
        return nettleLeaves;
    }

    public void setNettleLeaves(int nettleLeaves) {
        this.nettleLeaves = nettleLeaves;
    }

    public int getOranges() {
        return oranges;
    }

    public void setOranges(int oranges) {
        this.oranges = oranges;
    }

    public int getPears() {
        return pears;
    }

    public void setPears(int pears) {
        this.pears = pears;
    }

    public int getPepper() {
        return pepper;
    }

    public void setPepper(int pepper) {
        this.pepper = pepper;
    }

    public int getPlums() {
        return plums;
    }

    public void setPlums(int plums) {
        this.plums = plums;
    }

    public int getRasperries() {
        return rasperries;
    }

    public void setRasperries(int rasperries) {
        this.rasperries = rasperries;
    }

    public int getRawMilk() {
        return rawMilk;
    }

    public void setRawMilk(int rawMilk) {
        this.rawMilk = rawMilk;
    }

    public int getRedCurrants() {
        return redCurrants;
    }

    public void setRedCurrants(int redCurrants) {
        this.redCurrants = redCurrants;
    }

    public int getRye() {
        return rye;
    }

    public void setRye(int rye) {
        this.rye = rye;
    }

    public int getStrawberries() {
        return strawberries;
    }

    public void setStrawberries(int strawberries) {
        this.strawberries = strawberries;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getTeaTreeBlossum() {
        return teaTreeBlossum;
    }

    public void setTeaTreeBlossum(int teaTreeBlossum) {
        this.teaTreeBlossum = teaTreeBlossum;
    }

    public int getTeaTreeLeaves() {
        return teaTreeLeaves;
    }

    public void setTeaTreeLeaves(int teaTreeLeaves) {
        this.teaTreeLeaves = teaTreeLeaves;
    }

    public int getVanilla() {
        return vanilla;
    }

    public void setVanilla(int vanilla) {
        this.vanilla = vanilla;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getWheat() {
        return wheat;
    }

    public void setWheat(int wheat) {
        this.wheat = wheat;
    }

    public int getYeast() {
        return yeast;
    }

    public void setYeast(int yeast) {
        this.yeast = yeast;
    }


    public BarStorage(int apples, int barley, int blackCurrants, int blueAgave, int camomileLeaves, int caramel,
                      int cherries, int cocaLeaves, int coffeeBeans, int corn, int cowBerries, int cranBerries, int darkGrapes,
                      int gooseBerries, int grapeFruits, int honey, int jupiterBerries, int lemons, int lightGrapes,
                      int nettleLeaves, int oranges, int pears, int pepper, int plums, int rasperries, int rawMilk,
                      int redCurrants, int rye, int strawberries, int sugar, int teaTreeBlossum, int teaTreeLeaves, int vanilla,
                      int water, int wheat, int yeast) {
        super();
        this.apples = apples;
        this.barley = barley;
        this.blackCurrants = blackCurrants;
        this.blueAgave = blueAgave;
        this.camomileLeaves = camomileLeaves;
        this.caramel = caramel;
        this.cherries = cherries;
        this.cocaLeaves = cocaLeaves;
        this.coffeeBeans = coffeeBeans;
        this.corn = corn;
        this.cowBerries = cowBerries;
        this.cranBerries = cranBerries;
        this.darkGrapes = darkGrapes;
        this.gooseBerries = gooseBerries;
        this.grapeFruits = grapeFruits;
        this.honey = honey;
        this.jupiterBerries = jupiterBerries;
        this.lemons = lemons;
        this.lightGrapes = lightGrapes;
        this.nettleLeaves = nettleLeaves;
        this.oranges = oranges;
        this.pears = pears;
        this.pepper = pepper;
        this.plums = plums;
        this.rasperries = rasperries;
        this.rawMilk = rawMilk;
        this.redCurrants = redCurrants;
        this.rye = rye;
        this.strawberries = strawberries;
        this.sugar = sugar;
        this.teaTreeBlossum = teaTreeBlossum;
        this.teaTreeLeaves = teaTreeLeaves;
        this.vanilla = vanilla;
        this.water = water;
        this.wheat = wheat;
        this.yeast = yeast;
    }

    public BarStorage() {

    }

}
