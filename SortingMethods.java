import java.util.Arrays;

public class SortingMethods
{
    public static void selection_sort(int[] nums)
    {
        for (int i = 0; i < nums.length - 1 ; i++)
        {
            int min = nums[i];
            int pos = i;

            for (int j = i; j < nums.length; j++)
            {
                if (nums[j] <= min) {
                    min = nums[j];
                    pos = j;
                }
            }

            nums[pos] = nums[i];
            nums[i] = min;

            System.out.println(Arrays.toString(nums));
        }
    }

    public static void bubble_sort(int [] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = nums.length - 1; j > i ; j--)
            {
                int temp = nums[j];

                if (nums[j-1] > nums[j])
                {
                    temp = nums[j-1];
                    nums[j-1] = nums[j];
                }

                nums[j] = temp;
            }
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void quick_sort(int [] nums, int start, int end)
    {
        if (start > end)
            return;

        int i = start;
        int j = end;
        int pivot = nums[start];
        int pos = start;

        while (i < j)
        {
            while (i < j && nums[j] > pivot)
                j--;

            while (i < j && nums[i] <= pivot)
                i++;

            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        nums[start] = nums[j];
        nums[j] = pivot;

        quick_sort(nums, start, j - 1);
        quick_sort(nums, j + 1, end);
    }

    public static void main (String [] args)
    {
        int [] test = {13,5,1,32,6,2};
        quick_sort(test, 0, test.length - 1);

        System.out.println(Arrays.toString(test));
    }
}
