#ifndef TEST_FRAMEWORK_H
#define TEST_FRAMEWORK_H

#include <stdio.h>

static int tests_run = 0;
static int tests_failed = 0;

#define ASSERT_EQ(expected, actual)                        \
    do                                                     \
    {                                                      \
        if ((expected) != (actual))                        \
        {                                                  \
            printf("\n");                                  \
            printf("  FAIL: %s:%d\n", __FILE__, __LINE__); \
            printf("  Expected: %d\n", (expected));        \
            printf("  Actual  : %d\n", (actual));          \
            tests_failed++;                                \
            return;                                        \
        }                                                  \
    } while (0)

#define RUN_TEST(test_func)                  \
    do                                       \
    {                                        \
        int failures_before = tests_failed;  \
                                             \
        tests_run++;                         \
                                             \
        printf("Running %-30s", #test_func); \
                                             \
        test_func();                         \
                                             \
        if (failures_before == tests_failed) \
        {                                    \
            printf("PASS\n");                \
        }                                    \
        else                                 \
        {                                    \
            printf("FAIL\n");                \
        }                                    \
    } while (0)

#define TEST_SUMMARY()                                     \
    do                                                     \
    {                                                      \
        printf("\n");                                      \
        printf("=====================================\n"); \
        printf("Tests Run    : %d\n", tests_run);          \
        printf("Tests Failed : %d\n", tests_failed);       \
        printf("Tests Passed : %d\n",                      \
               tests_run - tests_failed);                  \
        printf("=====================================\n"); \
    } while (0)

#endif