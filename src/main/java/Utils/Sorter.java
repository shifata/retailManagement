package Utils;

import Movies.Movie;
import OrderMaintainance.Order;

import java.util.ArrayList;

public class Sorter {

    public static void sortMoviesById(ArrayList<Movie> movies) {
        for (int i = 0; i < movies.size(); i++) {
            for (int j = 0; j < movies.size(); j++) {
                if (Integer.parseInt(movies.get(i).getId()) < Integer.parseInt(movies.get(j).getId())) {
                    swap1(movies, i, j);
                }
            }
        }
    }

    public static void sortOrdersById(ArrayList<Order> orders) {
        for (int i = 0; i < orders.size(); i++) {
            for (int j = 0; j < orders.size(); j++) {
                if (Integer.parseInt(orders.get(i).getOrderId()) <
                        Integer.parseInt(orders.get(j).getOrderId())) {
                    swap2(orders, i, j);
                }
            }
        }
    }

    private static void swap1(ArrayList<Movie> movies, int a, int b) {
        Movie tmp = movies.get(a);
        movies.set(a, movies.get(b));
        movies.set(b, tmp);
    }

    private static void swap2(ArrayList<Order> orders, int a, int b) {
        Order tmp = orders.get(a);
        orders.set(a, orders.get(b));
        orders.set(b, tmp);
    }
}
