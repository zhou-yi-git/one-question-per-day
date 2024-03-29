# [142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)

### 解法一：双指针
先使用快慢指针(快指针步长2，慢指针步长1)进行相遇判断，当快慢指针相遇时，慢指针在环中遍历，同时头节点开始遍历，当两者相遇时，则为入环的第一个节点。
>原理：当快慢指针相遇时，假设慢指针走了n步，快指针则走了2n步，假设入环的节点距离头节点为m步，则慢指针在环中走了n-m步，快指针在环中走了2n-m步，那么一个环有(2n-m) - (n-m) = n步。由此可得，慢指针在环中还有n - (n-m) = m步，与头节点到入环第一个节点的步数相同。