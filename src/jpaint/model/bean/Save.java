/*
 * casse para salvar novas figuras no banco;
 * 
 * 
 */

package jpaint.model.bean;

/**
 *
 * @author pompeu
 */
public class Save {
    
    private int pkSave;
    private String saveName;

    public Save(int pkSave, String saveName) {
        setPkSave(pkSave);
        setSaveName(saveName);
    }

    public int getPkSave() {
        return pkSave;
    }

    public void setPkSave(int pkSave) {
        this.pkSave = pkSave;
    }

    public String getSaveName() {
        return saveName;
    }

    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }

    @Override
    public String toString() {
        return "Save{" + "pkSave=" + pkSave + ", saveName=" + saveName + '}';
    }
    
    
}
