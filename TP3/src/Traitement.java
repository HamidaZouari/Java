import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Traitement {
    private final String SELECT_ALL = "select * from produit";
    private final String FILTER_BY_NAME = "select * from produit where libelle like ?";

    public void save(Produit p ){
        try {
            PreparedStatement st = Connect.getConnection().prepareStatement("insert into produit values(?,?,?)");
            st.setInt(1,p.getId());
            st.setString(2,p.getLibelle());
            st.setDouble(3,p.getprix());
            int res = st.executeUpdate();
            if (res == 0)
            {
                System.out.println("Echec");
            }
            else
                System.out.println("Product successfully saved");

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Produit> produitsParMC(String mc) {
        List<Produit> listProduit = new ArrayList<>();
        try {
            PreparedStatement pd = Connect.getConnection().prepareStatement(FILTER_BY_NAME);
            pd.setString(1, "%"+mc+"%");
            System.out.println(pd.toString());
            ResultSet rs = pd.executeQuery();
            while (rs.next()) {
                Produit p = new Produit(rs.getInt(1), rs.getString(2), rs.getFloat(3));
                listProduit.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProduit;
    }
    public Produit getProduit(Long id){
        try {
            PreparedStatement st = Connect.getConnection().prepareStatement("select * from produit where id =" + id);
            ResultSet res = st.executeQuery();
            while(res.next()) {
                Produit p =new Produit(res.getInt(1), res.getString(2), res.getDouble(3));
                return p;
            }

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;

    }
    public Produit updateProduit(Produit p) {
        try {
            PreparedStatement st = Connect.getConnection().prepareStatement("update produit set  libelle=? , prix=? where id=?");
            st.setInt(1, p.getId());
            st.setString(2, p.getLibelle());
            st.setDouble(3, p.getprix());
            st.executeUpdate();
            return new Produit(p.getId(),p.getLibelle(),p.getprix());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    public void deleteProduit(int id){
        try{
            PreparedStatement st = Connect.getConnection().prepareStatement("delete from produit where id = "+id);
        //    st.setInt(1, id);
            st.executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Produit> getAllProduits() {
        List<Produit> listProduit = new ArrayList<>();
        try {
            Statement st =  Connect.getConnection().createStatement();
            ResultSet rs = st.executeQuery(SELECT_ALL);
            while (rs.next()) {
                Produit p = new Produit(rs.getInt(1), rs.getString(2), rs.getFloat(3));
                listProduit.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProduit;
    }

}

