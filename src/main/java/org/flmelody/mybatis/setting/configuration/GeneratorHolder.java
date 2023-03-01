package org.flmelody.mybatis.setting.configuration;

import com.google.common.collect.*;

import java.util.*;

/**
 * @author flmelody
 */
public final class GeneratorHolder {
    /**
     * The constant UPDATE_GENERATOR.
     */
    public static final AbstractStatementGenerator UPDATE_GENERATOR = new UpdateGenerator("update", "modify", "set");

    /**
     * The constant SELECT_GENERATOR.
     */
    public static final AbstractStatementGenerator SELECT_GENERATOR = new SelectGenerator("select", "get", "look", "find", "list", "search", "query");

    /**
     * The constant DELETE_GENERATOR.
     */
    public static final AbstractStatementGenerator DELETE_GENERATOR = new DeleteGenerator("del", "delete", "cancel");

    /**
     * The constant INSERT_GENERATOR.
     */
    public static final AbstractStatementGenerator INSERT_GENERATOR = new InsertGenerator("insert", "add", "new");

    /**
     * The constant ALL.
     */
    public static final Set<AbstractStatementGenerator> ALL = ImmutableSet.of(UPDATE_GENERATOR, SELECT_GENERATOR, DELETE_GENERATOR, INSERT_GENERATOR);
}
