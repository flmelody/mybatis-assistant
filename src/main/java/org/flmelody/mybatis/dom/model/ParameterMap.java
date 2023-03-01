package org.flmelody.mybatis.dom.model;

import com.intellij.psi.PsiClass;
import com.intellij.util.xml.Attribute;
import com.intellij.util.xml.Convert;
import com.intellij.util.xml.GenericAttributeValue;
import com.intellij.util.xml.SubTagList;
import org.flmelody.mybatis.dom.converter.AliasConverter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * The interface Parameter map.
 *
 * @author yanglin
 */
public interface ParameterMap extends IdDomElement {

    /**
     * Gets type.
     *
     * @return the type
     */
    @NotNull
    @Attribute("type")
    @Convert(AliasConverter.class)
    GenericAttributeValue<PsiClass> getType();

    /**
     * Gets parameters.
     *
     * @return the parameters
     */
    @SubTagList("parameter")
    List<Parameter> getParameters();

}
