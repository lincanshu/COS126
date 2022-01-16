public class Sum {

    public static void main(String[] args) {
//        System.out.println(args.length);
        int[] array = new int[args.length];
        // ���ַ�������ת��Ϊint����
        for (int i = 0; i < args.length; i++)
        {
            array[i] = Integer.parseInt(args[i]);
        }
        // ��ӡ���е���ֵ
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
        // forѭ�����
        int result = sum(array, 0);
        System.out.println("their sum is " + result);
    }

    public static int sum(int[] array)
    {
        int res = 0;
        for (int i = 0; i < array.length; i++)
        {
            res += array[i];
        }
        return res;
    }

    public static int sum(int[] array, int index)
    {
        if (index == array.length)
        {
            return 0;
        }
        return array[index] + sum(array, index + 1);
    }

}
