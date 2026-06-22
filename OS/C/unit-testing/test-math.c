#include <stdio.h>
#include "math.h"
#include "unit-test.h"

void test_add()
{
    ASSERT_EQ(5, add(2, 3));
    ASSERT_EQ(0, add(-1, 1));
}

int main()
{
    RUN_TEST(test_add);
    TEST_SUMMARY();
    return 0;
}