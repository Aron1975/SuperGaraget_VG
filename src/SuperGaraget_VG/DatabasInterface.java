package SuperGaraget_VG;

import SuperGaraget_VG.FordonFactory.FordonInterface;

import java.util.List;

public interface DatabasInterface {
    public int sparaFordon(List<FordonInterface> parkeradeF);
    public int läsInFordon(Garage garage);
}
