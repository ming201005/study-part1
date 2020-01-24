package com.chapter04.comm;

import java.io.*;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文件操作工具类
 * @author ming
 */
public class FileUtil {

    /*** 可读权限 ***/
    public static final int CAN_READ = 1;
    /*** 可写权限 ***/
    public static final int CAN_WRITE = 2;
    /*** 可执行权限 ***/
    public static final int CAN_EXECUTE = 3;

    private static Pattern absPathPat = Pattern.compile("^\\w:[/\\\\].+|^/.+");

    private static Pattern winReserved = Pattern.compile("(^|[\\\\/])(aux|com1|com2|prn|con|nul)($|[\\\\/])");

    private static Pattern pathExpandPat = Pattern.compile("^(~|\\.{1,2})(.+)");

    /**
     * 读取文件到字节数组
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public byte[] getContent(String filePath) throws IOException {
        File file = new File(filePath);
        long fileSize = file.length();
        if (fileSize > Integer.MAX_VALUE) {
            System.out.println("file too big...");
            return null;
        }
        FileInputStream fi = new FileInputStream(file);
        byte[] buffer = new byte[(int) fileSize];
        int offset = 0;
        int numRead = 0;
        while (offset < buffer.length && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
            offset += numRead;
        }
        fi.close();
        if (offset != buffer.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }
        return buffer;
    }

    /**
     * 读取文件到字节数组 the traditional io way
     *
     * @param filename
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray(String filename) throws IOException {

        File f = new File(filename);
        if (!f.exists()) {
            throw new FileNotFoundException(filename);
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(f));
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bos.close();
        }
    }

    /**
     * 读取文件到字节数组 NIO way
     *
     * @param filename
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray2(File filename) throws IOException {

        if (!filename.exists()) {
            throw new FileNotFoundException(filename.getName());
        }

        FileChannel channel = null;
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(filename);
            channel = fs.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
            while ((channel.read(byteBuffer)) > 0) {
                // do nothing
                // System.out.println("reading");
            }
            return byteBuffer.array();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取文件到字节数组 Mapped File way MappedByteBuffer*
     *
     * @param filename
     * @return
     * @throws IOException
     */
    @SuppressWarnings("resource")
    public static byte[] toByteArray3(String filename) throws IOException {

        FileChannel fc = null;
        try {
            fc = new RandomAccessFile(filename, "r").getChannel();
            MappedByteBuffer byteBuffer = fc.map(MapMode.READ_ONLY, 0, fc.size()).load();
            System.out.println(byteBuffer.isLoaded());
            byte[] result = new byte[(int) fc.size()];
            if (byteBuffer.remaining() > 0) {
                // System.out.println("remain");
                byteBuffer.get(result, 0, byteBuffer.remaining());
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                fc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 计算文件的 MD5 值
     *
     * @param file
     * @return
     */
    public static String getFileMD5(File file) {
        if (!file.isFile()) {
            return null;
        }
        MessageDigest digest = null;
        FileInputStream in = null;
        byte buffer[] = new byte[8192];
        int len;
        try {
            digest = MessageDigest.getInstance("MD5");
            in = new FileInputStream(file);
            while ((len = in.read(buffer)) != -1) {
                digest.update(buffer, 0, len);
            }
            BigInteger bigInt = new BigInteger(1, digest.digest());
            return bigInt.toString(16);

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * 计算文件的 MD5 值
     *
     * @param in
     * @return
     */
    public static String getFileMD5InputStream(InputStream in) {

        MessageDigest digest = null;
        byte buffer[] = new byte[8192];
        int len;
        try {
            digest = MessageDigest.getInstance("MD5");
            while ((len = in.read(buffer)) != -1) {
                digest.update(buffer, 0, len);
            }
            BigInteger bigInt = new BigInteger(1, digest.digest());
            return bigInt.toString(16);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * 判断文件是否有某权限
     *
     * @param path
     * @param priv
     * @return
     */
    public static boolean HasPriv(String path, int priv) {
        File file = new File(path);
        switch (priv) {
            case CAN_READ:
                return file.canRead();
            case CAN_WRITE:
                return file.canWrite();
            case CAN_EXECUTE:
                return file.canExecute();
        }

        return false;
    }

    /**
     * 新建一个文件夹
     *
     * @param folderPath
     * @return
     */
    public static boolean CreateFolders(String folderPath) {
        String filePath;
        filePath = folderPath;
        File myFilePath = new File(filePath);
        try {
            // 如果该文件夹不存在，则生成新的空文件夹
            if (!myFilePath.exists()) {
                return myFilePath.mkdirs();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 新建一个文件
     *
     * @param filePath
     * @return
     */
    public static boolean CreateFile(String filePath) {
        File myFilePath = new File(filePath);
        try {
            // 如果该文件不存在，则生成新的空文件
            if (!myFilePath.exists()) {
                return myFilePath.createNewFile();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 遍历删除已存在文件夹
     *
     * @param folderPath
     * @return
     */
    public static boolean DeleteFolder(String folderPath) {
        boolean trueflag = false;
        try {
            String filePath;
            filePath = folderPath;
            File myFilePath = new File(filePath);
            // 判断原文件是否存在
            if (myFilePath.exists()) {
                DeleteFile(myFilePath);
                trueflag = true;
            } else {
                trueflag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trueflag;
    }

    /**
     * 删除文件
     *
     * @param file
     */
    public static void DeleteFile(String file) {
        DeleteFile(new File(file));
    }

    /**
     * 删除文件或文件夹
     *
     * @param file
     */
    public static void DeleteFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                File files[] = file.listFiles();
                for (File file2 : files) {
                    DeleteFile(file2);
                }
                file.delete();
            }
        }
    }

    /**
     * 判断某文件或文件夹是否存在
     *
     * @param fileStr
     * @return
     */
    public static boolean FileExist(String fileStr) {
        try {
            File file = new File(fileStr);
            return file.exists() && file.isFile();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 文件夹是否存在
     *
     * @param folderStr
     * @return
     */
    public static boolean FolderExist(String folderStr) {
        try {
            File file = new File(folderStr);
            return file.exists() && file.isDirectory();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据条件枚举文件
     *
     * @param folder
     * @param pattern
     * @param isRecursive
     * @return
     */
    public static List<String> EnumFile(String folder, final String pattern, final boolean isRecursive) {
        final Stack<String> dirStack = new Stack<String>();
        final List<String> fileList = new ArrayList<String>();

        if (!FolderExist(folder))
            return fileList;

        dirStack.push(folder);
        while (dirStack.size() > 0) {
            String dirStr = dirStack.pop();
            File dir = new File(dirStr);
            dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    File findFile = new File(dir, name);
                    if (findFile.isDirectory() && isRecursive) {
                        dirStack.push(findFile.getAbsolutePath());
                        return false;
                    }

                    if (name.matches(pattern) && findFile.isFile()) {
                        fileList.add(findFile.getAbsolutePath());
                    }

                    return false;
                }
            });
        }

        return fileList;
    }

    public static List<String> EnumFile(File folder, final String pattern, final boolean isRecursive) {
        return EnumFile(folder.getAbsolutePath(), pattern, isRecursive);
    }

    /**
     * copy File
     *
     * @param srcPath
     * @param destPath
     * @return
     */
    public static boolean CopyFile(String srcPath, String destPath) {
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);
        // 如果目标文件所在目录不存在，则创建一下
        CreateFolders(destFile.getParent());

        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(srcFile);
            os = new FileOutputStream(destFile);
            byte[] bt = new byte[1024];
            int count = 0;
            while ((count = is.read(bt)) != -1) {
                os.write(bt, 0, count);
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 重命名文件
     *
     * @param from
     *            源文件名
     * @param to
     *            目标文件名
     */
    public static boolean Rename(String from, String to) {
        File file = new File(from);
        return file.renameTo(new File(to));
    }

    public static List<String> LoadTextInLineFromStream(InputStream stream, String encoding) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, encoding));

            try {
                List<String> lst = new ArrayList<String>();
                String line;
                while ((line = reader.readLine()) != null) {
                    lst.add(line);
                }

                return lst;
            } finally {
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 逐行加载文本文件
     */
    public static List<String> LoadTextInLineFromFile(File path, String encoding) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            return LoadTextInLineFromStream(fileInputStream, encoding);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 加载二进制文件
     *
     * @param file
     *            文件路径
     */
    public static byte[] LoadBinaryFile(File file) {
        BufferedInputStream in = null;

        try {
            in = new BufferedInputStream(new FileInputStream(file));
            byte[] buf = new byte[in.available()];

            in.read(buf);
            return buf;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String LoadTextFromStream(InputStream stream, String encoding) {
        List<String> lines = LoadTextInLineFromStream(stream, encoding);
        if (lines == null)
            return null;

        StringBuilder str = new StringBuilder();
        for (String line : lines) {
            str.append(line).append("\n");
        }
        return str.toString();
    }

    public static String LoadTextFile(File path, String encoding) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            return LoadTextFromStream(fileInputStream, encoding);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将字符串输出到文件
     *
     * @param str
     *            字符串
     * @param encoding
     *            编码
     * @return 成功返回true，失败返回false
     */
    public static boolean WriteToFile(File file, String str, String encoding) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encoding));
            writer.write(str);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 保存二进制数据到文件
     *
     * @param destFile
     *            文件路径
     * @param data
     *            数据
     */
    public static boolean WriteToFile(File destFile, byte[] data) {
        BufferedOutputStream out = null;

        try {
            out = new BufferedOutputStream(new FileOutputStream(destFile));
            out.write(data);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 逐行处理文件
     *
     * @param txtFile
     * @param encoding
     * @param opt
     *            处理接口回调StringOperator
     */

    public static void EachLineFromFile(File txtFile, String encoding, StringOperator opt) {
        assert opt != null;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(txtFile), encoding));

            try {
                String line;
                int idx = 0;
                while ((line = reader.readLine()) != null) {
                    opt.One(idx, line);
                    idx++;
                }
            } finally {
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 用于处理字符串的回调
     */
    public interface StringOperator {
        public void One(int idx, String str);
    }

    /**
     * 枚举目录
     */
    public static List<String> EnumFolder(String dir, final String pat) {
        final List<String> fileList = new ArrayList<String>();

        if (!FolderExist(dir))
            return fileList;

        new File(dir).listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File findFile = new File(dir, name);
                if (findFile.isDirectory()) {
                    if (pat != null && !findFile.getName().matches(pat)) {
                        // 不符合要求的过滤掉
                        return false;
                    }

                    fileList.add(findFile.getAbsolutePath());
                }

                return false;
            }
        });

        return fileList;
    }

    /**
     * 获取文件的后缀名
     */
    public static String GetExtName(String name) {
        int pos = name.indexOf('.');
        if (pos == -1) {
            return "";
        } else {
            return name.substring(pos + 1, name.length());
        }
    }

    /**
     * 保存输入流中的数据到文件
     */
    public static void WriteStreamToFile(File file, InputStream stream) {
        // 如果父目录不存在，就先创建一个
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        byte[] buf = new byte[1024 * 1024];
        int funcRet = 0;

        BufferedOutputStream out = null;
        try {
            out = new BufferedOutputStream(new FileOutputStream(file));

            while ((funcRet = stream.read(buf)) > 0) {
                out.write(buf, 0, funcRet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 判断文件夹是否有效 尝试创建一下即可
     */
    public static boolean IsValidFolder(String folder) {
        // 如果是windows过滤一下windows保留字
        if (System.getProperty("os.name").matches(".*Window.*")) {
            if (winReserved.matcher(folder).find()) {
                return false;
            }
        }

        if (FileUtil.FolderExist(folder)) {
            return true;
        } else {
            File file = new File(folder);
            return file.mkdirs();
        }
    }

    /**
     * 当前目录
     */
    public static String WordDir() {
        return System.getProperty("user.dir").replace("\\", "/");
    }

    /**
     * 家目录
     */
    public static String HomeDir() {
        return System.getProperty("user.home").replace("\\", "/");
    }

    /**
     * 根据常见的目录缩写进行展开
     *
     * @param input
     *            原始目录
     * @return 展开后的目录
     */
    public static String ExpandPath(String input) {
        Matcher mat = pathExpandPat.matcher(input);

        if (!mat.matches()) {
            return new File(input).getAbsolutePath();
        }

        String prefix = mat.group(1);
        String sub = mat.group(2);

        if (prefix.equals("~")) {
            return CombinePath(HomeDir(), sub);
        } else if (prefix.equals(".")) {
            return CombinePath(WordDir(), sub);
        } else if (prefix.equals("..")) {
            // 可能存在../../../的情况，这里做一下处理
            Pattern pattern = Pattern.compile("(\\..)");
            Matcher matcher = pattern.matcher(sub);
            int count = 1;
            while (matcher.find()) {
                count++;
            }
            String dir = WordDir();
            for (int i = 0; i < count; i++) {
                String parent = new File(dir).getParent();
                if (parent != null) {
                    dir = parent;
                }
            }
            sub = sub.substring(sub.lastIndexOf("/"), sub.length());
            if (dir.length() == 1 && dir.indexOf("/") == 0) { // linux环境下的根目录
                return sub;
            }
            return CombinePath(dir, sub);
        } else {
            return new File(input).getAbsolutePath();
        }
    }

    /**
     * 生成组合路径
     *
     * @param base
     *            父目录
     * @param sub
     *            子路径
     */
    public static String CombinePath(String base, String sub) {
        // 如果是根目录,直接合并
        if (base.equals("/")) {
            return base + sub;
        }
        return CombineWithSplitter(base, sub, "/");
    }

    /**
     * 使用指定的分隔符合并两个字符串 分隔符会和第一个字符串末尾、第二个字符串的开头出现的对应字符进行合并
     *
     * @param one
     *            第一个字符串
     * @param two
     *            第二个字符串
     * @param splitter
     *            分隔符
     * @return 合并后的字符串
     */
    public static String CombineWithSplitter(String one, String two, String splitter) {
        StringBuilder finalStr = new StringBuilder();
        int splitterPos = one.lastIndexOf(splitter);
        if ((splitterPos != -1) && (splitterPos + splitter.length() == (one.length()))) {
            finalStr.append(one.substring(0, splitterPos));
        } else {
            finalStr.append(one);
        }

        if (finalStr.length() > 0)
            finalStr.append(splitter);

        splitterPos = two.indexOf(splitter);
        if (splitterPos == 0) {
            finalStr.append(two.substring(splitterPos + splitter.length()));
        } else {
            finalStr.append(two);
        }

        return finalStr.toString();
    }

    /**
     * 判断一个目录是否是绝对路径 绝对目录：Unix/Linux下以/开头；windows下以盘符开头
     */
    public static boolean IsAbsolutePath(String path) {
        Matcher mat = absPathPat.matcher(path);
        return mat.matches();
    }

}

