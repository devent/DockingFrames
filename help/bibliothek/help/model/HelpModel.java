package bibliothek.help.model;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelpModel {
    private Map<String, Entry> entries = new HashMap<String, Entry>();
    
    public HelpModel( File file ) throws IOException{
        DataInputStream in = new DataInputStream( new BufferedInputStream( new FileInputStream( file )));
        List<Entry> list = EntryIO.readList( in );
        in.close();
        for( Entry entry : list )
            entries.put( entry.getType() + ":" + entry.getId(), entry );
    }
    
    public Entry get( String link ){
        return entries.get( link );
    }
}
