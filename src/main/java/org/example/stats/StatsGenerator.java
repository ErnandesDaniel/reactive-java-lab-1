package org.example.stats;

import org.example.models.User.User;
import org.example.models.User.UserActivity;
import org.example.models.User.UserGenerator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatsGenerator {

    // 3.1. Итерационный цикл
    public static StatsResult calculateWithLoop(int userCount) {
        long start = System.nanoTime();
        List<User> users = UserGenerator.generateUsers(userCount);

        long totalDecks = 0;
        long activeUsers = 0;
        long inactiveUsers = 0;

        for (User user : users) {
            totalDecks += user.getDecks().size();
            if (user.getUserActivity() == UserActivity.ACTIVE) {
                activeUsers++;
            } else if (user.getUserActivity() == UserActivity.INACTIVE) {
                inactiveUsers++;
            }
        }

        double avgDecksPerUser = userCount > 0 ? (double) totalDecks / userCount : 0.0;

        long end = System.nanoTime();

        return new StatsResult(totalDecks, avgDecksPerUser, activeUsers, inactiveUsers, end - start);
    }

    // 3.2. Stream API с встроенными коллекторами
    public static StatsResult calculateWithBuiltInCollectors(int userCount) {
        long start = System.nanoTime();
        List<User> users = UserGenerator.generateUsers(userCount);

        long totalDecks = users.stream()
                .mapToLong(u -> u.getDecks().size())
                .sum();

        Map<UserActivity, Long> activityCounts = users.stream()
                .collect(Collectors.groupingBy(
                        User::getUserActivity,
                        Collectors.counting()
                ));

        long active = activityCounts.getOrDefault(UserActivity.ACTIVE, 0L);
        long inactive = activityCounts.getOrDefault(UserActivity.INACTIVE, 0L) +
                activityCounts.getOrDefault(UserActivity.SUSPENDED, 0L);

        double avgDecksPerUser = userCount > 0 ? (double) totalDecks / userCount : 0.0;
        long end = System.nanoTime();

        return new StatsResult(totalDecks, avgDecksPerUser, active, inactive, end - start);
    }

    // 3.3. Stream API с собственным коллектором
    public static StatsResult calculateWithCustomCollector(int userCount) {
        long start = System.nanoTime();
        List<User> users = UserGenerator.generateUsers(userCount);

        StatsResult result = users.stream()
                .collect(new UserStatsCollector());

        long end = System.nanoTime();
        return new StatsResult(
                result.totalDecks,
                result.avgDecksPerUser,
                result.activeUsers,
                result.inactiveUsers,
                end - start
        );
    }
}




