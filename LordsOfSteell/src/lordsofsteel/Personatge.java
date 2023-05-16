
package lordsofsteel;

 //  @author Ricard
public abstract class Personatge {
    
    
    protected String nom;
    protected Arma arma;
    protected int forca;
    protected int constitucio;
    protected int velocitat;
    protected int inteligencia;
    protected int sort;
    
    protected int exp = 0; // experiencia
    protected int lvl = 0; // nivell
    protected int maxlvl = 5; //nivell maxim
    protected int[] lvlexp = {100, 200, 300, 400, 500}; //experiencia per pujar de nivell

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getMaxlvl() {
        return maxlvl;
    }

    public void setMaxlvl(int maxlvl) {
        this.maxlvl = maxlvl;
    }

    public int[] getLvlexp() {
        return lvlexp;
    }

    public void setLvlexp(int[] lvlexp) {
        this.lvlexp = lvlexp;
    }
    public void guanayExp(int PsRival){
        this.setExp(this.getExp()+PsRival);
        if (this.getExp()>=this.lvlexp[this.getLvl()]) {
            this.setLvl(this.getLvl()+1);
            this.setExp(this.getExp()-this.lvlexp[this.getLvl()-1]);
            System.out.println(this.getNom()+" ha pujat al nivell "+this.getLvl()+"!");
            this.setMaxP(this.getMaxP()+5);
            this.setForca(this.getForca()+1);
            this.setConstitucio(this.getConstitucio()+1);
            this.setVelocitat(this.getVelocitat()+1);
            this.setInteligencia(this.getInteligencia()+1);
            this.setSort(this.getSort()+1);
            this.calculaEstadistiquesSecundaries();
        }
    
    }
    protected int maxP = 60; 
    protected int ps;  // Punts de salut
    protected int pd;  // Punts de dany
    protected int pa;  // Probabilitat d'atac
    protected int pe;  // Probabilitat d'esquivar
    
    public Personatge(String nom, int forca, int constitucio, int velocitat,
                      int inteligencia, int sort, Arma arma) {
        this.nom           = nom;
        this.forca         = forca;
        this.constitucio   = constitucio;
        this.velocitat     = velocitat;
        this.inteligencia = inteligencia;
        this.sort          = sort;
        this.arma          = arma;
        calculaEstadistiquesSecundaries();
    }
                      
    protected void calculaEstadistiquesSecundaries() {
        ps = constitucio + forca;
        pd = (forca + arma.getWpow())/4;
        pa = inteligencia + sort;
        pe = velocitat + sort + inteligencia;
    }

    
    public int getForca() {
        return forca;
    }

    public int getConstitucio() {
        return constitucio;
    }

    public int getVelocitat() {
        return velocitat;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getSort() {
        return sort;
    }

    public int getPs() {
        return ps;
    }

    public int getPd() {
        return pd;
    }

    public int getPa() {
        return pa;
    }

    public int getPe() {
        return pe;
    }

    public Arma getArma() {
        return arma;
    }

    
    public void setForca(int forca) {
        this.forca = forca;
    }

    public void setConstitucio(int constitucio) {
        this.constitucio = constitucio;
    }

    public void setVelocitat(int velocitat) {
        this.velocitat = velocitat;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
    public int getMaxP() {
        return maxP;
    }

    public void setMaxP(int maxP) {
        this.maxP = maxP;
    }
    public void setPs(int ps) {
        this.ps = ps;
    }

    public void setPd(int pd) {
        this.pd = pd;
    }

    public void setPa(int pa) {
        this.pa = pa;
    }

    public void setPe(int pe) {
        this.pe = pe;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void restauraPS(){
        this.ps = (int)(this.ps * 1.1);
    }
    
    public boolean ContraAtaca(Dau ... d){
        int valor = d[0].llencar()+d[1].llencar()+d[2].llencar();
        if(valor <=(this.getPa()/2)){
            return true;
        }else{
            return false;
        }
    }
    public abstract String mostraNomTipus();
}
