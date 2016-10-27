import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.IOException;

/**
 * Created by lifei13 on 2016/10/27.
 */
public class UpLoadTest {

    public static void main(String[] args) throws IOException, MyException {
        String local_filename = "E:\\workspace_idea\\fastDFSAPI\\target\\classes\\README";
        ClientGlobal.init("E:\\workspace_idea\\fastDFSAPI\\target\\classes\\fdfs_client.conf");
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient1 client = new StorageClient1(trackerServer, storageServer);

        NameValuePair[] metaList = new NameValuePair[1];
        metaList[0] = new NameValuePair("fileName", local_filename);
        String fileId = client.upload_file1(local_filename, null, metaList);
        System.out.println("upload success. file id is: " + fileId);
        trackerServer.close();

    }
}
