package com.company.model.homeelectricalappliances.builder;

import com.company.model.homeelectricalappliances.EnergyEfficiencyClass;
import com.company.model.homeelectricalappliances.SizeType;
import com.company.model.homeelectricalappliances.light.LightType;
import com.company.model.homeelectricalappliances.parameters.DefaultParameter;
import com.company.model.homeelectricalappliances.parameters.Parameters;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * class director, which now how to create some new devices
 */
public class BuilderManager {
    /**
     * receipt of new tv
     * @param builder appliances builder
     */
    public void createSamsung20TV(Builder builder) {
        builder.setCountry("Korea");
        builder.setName("TV");
        builder.setDate(LocalDate.now());
        builder.setDescription("Small but quality");
        builder.setEfficiencyClass(EnergyEfficiencyClass.B);
        builder.setGuarantyPeriod(Period.ofYears(3));


        Set<Parameters> parameters = Stream.of(
                new DefaultParameter("20 inch display"),
                new DefaultParameter("black body")
        )
                .collect(Collectors.toSet());
        builder.setParameters(parameters);

        builder.setPower(40);
        builder.setVoltage(220);
        builder.setSizeType(SizeType.LOW);

    }

    /**
     * receipt of new tv
     * @param builder appliances builder
     */
    public void createSamsung40TV(Builder builder) {
        builder.setName("TV");
        builder.setCountry("Korea");
        builder.setDate(LocalDate.now());
        builder.setDescription("Good for all");
        builder.setEfficiencyClass(EnergyEfficiencyClass.C);
        builder.setGuarantyPeriod(Period.ofYears(4));

        Set<Parameters> parameters = Stream.of(
                new DefaultParameter("40 inch display"),
                new DefaultParameter("glass body")
        )
                .collect(Collectors.toSet());

        builder.setParameters(parameters);

        builder.setPower(60);
        builder.setVoltage(220);
        builder.setSizeType(SizeType.MEDIUM);
    }

    /**
     * receipt of new tv
     * @param builder appliances builder
     */
    public void createSamsung60TV(Builder builder) {
        builder.setName("TV");
        builder.setCountry("Korea");
        builder.setDate(LocalDate.now());
        builder.setDescription("Cinema at your home");
        builder.setEfficiencyClass(EnergyEfficiencyClass.B);
        builder.setGuarantyPeriod(Period.ofYears(2));


        Set<Parameters> parameters = Stream.of(
                new DefaultParameter("60 inch display"),
                new DefaultParameter("glass body"),
                new DefaultParameter("flexible")
        )
                .collect(Collectors.toSet());
        builder.setParameters(parameters);

        builder.setPower(65);
        builder.setVoltage(220);
        builder.setSizeType(SizeType.HUGE);
    }

    /**
     * receipt of new fridge
     * @param builder appliances builder
     */
    public void createAtlantFridge(Builder builder) {
        builder.setName("Fridge");
        builder.setCountry("Belarus");
        builder.setDate(LocalDate.now());
        builder.setDescription("With bison power inside");
        builder.setEfficiencyClass(EnergyEfficiencyClass.F);
        builder.setGuarantyPeriod(Period.ofYears(25));

        Set<Parameters> parameters = Stream.of(
                new DefaultParameter("200 litres volume"),
                new DefaultParameter("magnet in the door")
        )
                .collect(Collectors.toSet());

        builder.setParameters(parameters);

        builder.setPower(60);
        builder.setVoltage(220);
        builder.setSizeType(SizeType.HUGE);
    }

    /**
     * receipt of new fridge
     * @param builder appliances builder
     */
    public void createLGFridge(Builder builder) {
        builder.setName("Fridge");
        builder.setCountry("Korea");
        builder.setDate(LocalDate.now());
        builder.setDescription("small fridge for one person");
        builder.setEfficiencyClass(EnergyEfficiencyClass.A);
        builder.setGuarantyPeriod(Period.ofYears(3));


        Set<Parameters> parameters = Stream.of(
                new DefaultParameter("75 litres volume"),
                new DefaultParameter("quiet")
        )
                .collect(Collectors.toSet());
        builder.setParameters(parameters);

        builder.setPower(20);
        builder.setVoltage(220);
        builder.setSizeType(SizeType.LOW);
    }

    /**
     * receipt of new lamp
     * @param builder appliances builder
     */
    public void createTableLamp(LightBuilder builder) {
        builder.setName("Lamp");
        builder.setCountry("China");
        builder.setDate(LocalDate.now());
        builder.setDescription("cute table lamp");
        builder.setEfficiencyClass(EnergyEfficiencyClass.C);
        builder.setGuarantyPeriod(Period.ofYears(1));


        Set<Parameters> parameters = Stream.of(
                new DefaultParameter("red"),
                new DefaultParameter("hot")
        )
                .collect(Collectors.toSet());
        builder.setParameters(parameters);

        builder.setPower(60);
        builder.setVoltage(220);
        builder.setSizeType(SizeType.LOW);
        builder.setLightType(LightType.COLD);
    }

    /**
     * receipt of new chandelier
     * @param builder appliances builder
     */
    public void createAncientChandelier(LightBuilder builder) {
        builder.setName("Chandelier");
        builder.setCountry("Italy");
        builder.setDate(LocalDate.of(1236, 10, 10));
        builder.setDescription("survived black death");
        builder.setEfficiencyClass(EnergyEfficiencyClass.G);
        builder.setGuarantyPeriod(Period.ofYears(1));

        Set<Parameters> parameters = Stream.of(
                new DefaultParameter("1000 electrical candles"),
                new DefaultParameter("servant in complement")
        )
                .collect(Collectors.toSet());

        builder.setParameters(parameters);

        builder.setPower(1000);
        builder.setVoltage(360);
        builder.setSizeType(SizeType.HUGE);
        builder.setLightType(LightType.WARM);
    }


}
