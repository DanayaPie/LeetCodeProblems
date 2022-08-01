nums = [0, 11, 9, 3]
target = 9


class Solution(object):

    def __init__(self, nums, target):
        self.nums = nums
        self.target = target

    def two_sum(self, nums, target):

        arr = {}

        for i, value in enumerate(nums):

            diff = target - value

            if diff in arr:
                return [arr[diff], i]

            arr[value] = i

        return [-1, -1]


res = Solution(nums, target)

print(res.two_sum(nums, target))
