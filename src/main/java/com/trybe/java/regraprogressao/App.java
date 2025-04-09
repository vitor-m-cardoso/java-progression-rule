package com.trybe.java.regraprogressao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * App.
 */
public class App {

  /**
   * Metodo main.
   */
  public static void main(String[] args) {
    Scanner scanMenu = new Scanner(System.in);
    List<Activity> activities = new ArrayList<>();
    double sumActivitiesWeigh = 0;

    System.out.println("Digite a quantidade de atividades para cadastrar:");
    String activitiesQuantity = scanMenu.nextLine();

    for (int index = 1; index <= Integer.parseInt(activitiesQuantity); index++) {
      System.out.println("Digite o nome da atividade " + index + ":");
      String activityName = scanMenu.nextLine();

      System.out.println("Digite o peso da atividade " + index + ":");
      String activityWeight = scanMenu.nextLine();
      int activityWeightInt = Integer.parseInt(activityWeight);

      System.out.println("Digite a nota obtida para " + activityName);
      String obtainedGrade = scanMenu.nextLine();
      int obtainedGradeInt = Integer.parseInt(obtainedGrade);

      sumActivitiesWeigh += activityWeightInt;
      activities.add(new Activity(activityName, activityWeightInt, obtainedGradeInt));
    }

    if (sumActivitiesWeigh != 100) {
      System.out.println("A soma dos pesos é diferente de 100!");
      return;
    }

    double sumActivitiesGrade = 0;
    for (Activity ac : activities) {
      sumActivitiesGrade += ac.grade() * ac.weight();

    }

    double finalGrade = sumActivitiesGrade / sumActivitiesWeigh;
    finalGrade = Math.round(finalGrade * 10.0) / 10.0;

    if (finalGrade >= 85.0) {
      System.out.println("Parabéns! Você alcançou " + finalGrade + "%! E temos o prazer de informar que você obteve aprovação!");
    } else {
      System.out.println("Lamentamos informar que, com base na sua pontuação alcançada neste período, " + finalGrade + "%, você não atingiu a pontuação mínima necessária para sua aprovação.");
    }

    scanMenu.close();
  }
}